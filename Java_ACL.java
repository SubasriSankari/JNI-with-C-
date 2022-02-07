Path path = Paths.get("C:\\Program Files\\JNI_Java_C\\JNI");

UserPrincipal authenticatedUsers = path.getFileSystem().getUserPrincipalLookupService()
        .lookupPrincipalByName("CREATOR OWNER");
AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);

for(AclEntry entry : view.getAcl()) {
    if(entry.principal().equals(authenticatedUsers)) {
        System.out.println("=== flags ===");
        for (AclEntryFlag flags : entry.flags()) {
            System.out.println(flags.name());
        }

        System.out.println("=== permissions ===");
        for (AclEntryPermission permission : entry.permissions()) {
            System.out.println(permission.name());
        }
    }
}
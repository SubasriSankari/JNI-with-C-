
import  java.io.*;
import  java.util.*;
import  java.nio.file.*;
import  java.nio.file.attribute.*;

public class JavaACL{

	public native void javaACL();
	static{
		System.loadLibrary("javaLibACL");
	}

	public static void main(String[] args) throws IOException{

		Path path = Paths.get("C:\\Program Files\\JNI_Java_C\\JavaACL\\sample4_JNI");

		AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);

		//System.out.println("Owner of the file is "+ view.getOwner().getName());

		if(view == null){
			System.out.format("ACL view is not supported.%n");
      			return;
		}
		
		try{
			JavaACL obj = new JavaACL();

			//******* This below code is used to show the list of permissions *******//
			/*List<AclEntry> aclEntries = view.getAcl();
      			for (AclEntry entry : aclEntries) {
        			System.out.format("Principal: %s%n", entry.principal());
        			System.out.format("Type: %s%n", entry.type());
        			System.out.format("Permissions are:%n");

			        Set<AclEntryPermission> permissions = entry.permissions();
	        		for (AclEntryPermission p : permissions) {
        				System.out.format("%s %n", p);
        			}

		        }*/

			/* **	WRITE_NAMED_ATTRS
				WRITE_ATTRIBUTES
				DELETE
				WRITE_DATA
				READ_ACL
				APPEND_DATA
				READ_ATTRIBUTES
				READ_DATA
				EXECUTE
				SYNCHRONIZE
				READ_NAMED_ATTRS     ** */
						


			//******* This below code is used for setting file permission*******//
			UserPrincipal authenticatedUsers = path.getFileSystem().getUserPrincipalLookupService()
        						.lookupPrincipalByName("DESKTOP-FE5FFTN\\LENOVO");
			GroupPrincipal groupUsers = path.getFileSystem().getUserPrincipalLookupService()
        						.lookupPrincipalByGroupName("Authenticated Users");
		
      			Set<AclEntryPermission> permissions = EnumSet.of( 
						AclEntryPermission.EXECUTE,
						AclEntryPermission.WRITE_DATA,                     			
                        			AclEntryPermission.DELETE,
                        			AclEntryPermission.READ_ACL,
                        			AclEntryPermission.APPEND_DATA,
                        			AclEntryPermission.READ_ATTRIBUTES,
                        			AclEntryPermission.SYNCHRONIZE,
                        			AclEntryPermission.READ_NAMED_ATTRS);

     			AclEntry.Builder builder = AclEntry.newBuilder();

      			builder.setPrincipal(groupUsers);
      			builder.setType(AclEntryType.ALLOW);
      			builder.setPermissions(permissions);
      			AclEntry newEntry = builder.build();
	

      			List<AclEntry> aclEntries = view.getAcl();

			aclEntries.add(newEntry);		

		        view.setAcl(aclEntries);

		        System.out.println("ACL entry added successfully");
			obj.javaACL();
			
		}catch(IOException e) {
      			System.out.println("Sorry!! Group name not found...Please try again!!");
    		}

	}
}
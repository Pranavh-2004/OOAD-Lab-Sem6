// Interface defining the security contract
interface Authenticator 
{
    // Abstract method: All security systems must have a login mechanism
    boolean login(String userId, String credentials);

    // Default method: Shared logic for logging out across all systems
    default void logout(String userId) 
    {
        System.out.println("User " + userId + " has been securely logged out.");
    }
}

// Security implementation 1: Traditional Password Authentication
class PasswordAuth implements Authenticator 
{
    @Override
    public boolean login(String userId, String password) 
    {
        // In a real app, you would verify a hashed password here
        System.out.println("Validating password for " + userId + "...");
        return password.equals("SecurePass123");
    }
}

// Security implementation 2: Modern Biometric Authentication
class BiometricAuth implements Authenticator 
{
    @Override
    public boolean login(String userId, String fingerprintData) 
    {
        // Logic for matching biometric patterns
        System.out.println("Scanning fingerprint for " + userId + "...");
        return fingerprintData.startsWith("FP_SCAN_OK");
    }
}

public class SecuritySystem 
{
    public static void main(String[] args) 
   {
        // Using the interface as a reference type (Polymorphism)
        Authenticator authService;

        // 1. Trying Password Auth
        authService = new PasswordAuth();
        if (authService.login("Admin_User", "SecurePass123")) 
        {
            System.out.println("Access Granted via Password.");
        }
        authService.logout("Admin_User");

        System.out.println("------------------------------------");

        // 2. Swapping to Biometric Auth
        authService = new BiometricAuth();
        if (authService.login("Secure_Vault_User", "FP_SCAN_OK_99")) 
        {
            System.out.println("Access Granted via Biometric Scan.");
        }
        authService.logout("Secure_Vault_User");
    }
}

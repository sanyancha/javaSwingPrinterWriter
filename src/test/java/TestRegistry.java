package test.java;

import lib.service.cipher.ServiceCipher;
import lib.repository.registry.RepositoryWinReg;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class TestRegistry {
    public static void main(String ... args) throws UnsupportedEncodingException {
        RepositoryWinReg reg = new RepositoryWinReg();

        // create a new registry key on HKEY_CURRENT_USER\\SOFTWARE\AAAA
        if( reg.addKey(RepositoryWinReg.WRKey.HKCU, "SOFTWARE\\AAAA") ) {
            System.out.println("Key created");
        }
        else {
            System.err.println("Error: could not create the key");
        }

        // create a new registry value on HKEY_CURRENT_USER\\SOFTWARE\AAAA  Name: sampleValue Type REG_SZ
        if( reg.addValue(RepositoryWinReg.WRKey.HKCU, "SOFTWARE\\AAAA", "sampleValue", "Tesalue", RepositoryWinReg.WRType.REG_SZ) ) {
            System.out.println("value created");
        }
        else {
            System.err.println("Error: could not create the value");
        }



        /*reg query "hklm\software\microsoft\windows nt\CurrentVersion"*/
        // list all registry values at HKEY_CURRENT_USER\\SOFTWARE\AAAA  with subdirectories
        String response = reg.showValue(RepositoryWinReg.WRKey.HKLM, "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion", "ProductId_test");
        if(response == null ) {
            System.err.println("Error: could not show the values");
        } else {
            System.out.println("Response = " + response);
        }

        byte[] encryptedByte = ServiceCipher.getInstance().encryptText(response.getBytes());

        String encrypted = ServiceCipher.getInstance().byteArrToString(encryptedByte);

        System.out.println("encrypted = " + encrypted);

        //SET DATA TO REGISTRY
        if( reg.addValue(RepositoryWinReg.WRKey.HKCU, "SOFTWARE\\LabelPrintingApp", "encrypted", encrypted, RepositoryWinReg.WRType.REG_SZ) ) {
            System.out.println("value created");
        }
        else {
            System.err.println("Error: could not create the value");
        }

        String registryEncryptedReg = reg.showValue(RepositoryWinReg.WRKey.HKCU, "SOFTWARE\\LabelPrintingApp", "encrypted");
        System.out.println("registryEncryptedReg = " + registryEncryptedReg);

        byte[] encryptedByteReg = registryEncryptedReg.getBytes(StandardCharsets.UTF_8);
        System.out.println(java.nio.charset.Charset.defaultCharset());
        if(registryEncryptedReg.equals(encrypted)){
            System.out.println("OK");
        } else {
            System.out.println("WRONG LICENSE KEY");
        }
    }
}

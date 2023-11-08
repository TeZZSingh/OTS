package gov.ifms.ots.common;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.PrivateKeySignature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

public class DigitalSignatureExample {
    public static void main(String[] args) {
        try {
            String inFile = "path_to_input.pdf";
            String outFilePath = "path_to_output_directory/";
            String rendome_txn = String.valueOf(new Random().nextInt(1000));

            Security.addProvider(new BouncyCastleProvider());

            // Load the keystore (replace "your_keystore.p12" and "keystore_password" with actual values)
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            FileInputStream keystoreFile = new FileInputStream("your_keystore.p12");
            char[] keystorePassword = "keystore_password".toCharArray();
            keystore.load(keystoreFile, keystorePassword);

            // Get the first private key and certificate from the keystore
            Enumeration<String> aliases = keystore.aliases();
            String alias = aliases.nextElement();
            PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword);
            X509Certificate certClient = (X509Certificate) keystore.getCertificate(alias);

            if (certClient != null) {
                List<X509Certificate> chain = new ArrayList<>();

                chain.add(certClient);

                byte[] signedDocument = null;
                byte[] contents = Files.readAllBytes(Paths.get(inFile));

                PdfReader reader = new PdfReader(contents);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');

                BouncyCastleProvider provider = new BouncyCastleProvider();

                PdfSignatureAppearance sap = stamper.getSignatureAppearance();
                sap.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_NO_CHANGES_ALLOWED);

                Rectangle rectangle = new Rectangle(150, 100, 400, 150);

                // Replace with your signature image creation logic
                byte[] byteImage = getSignature(new String[]{
                        "Digitally Signed by: " + certClient.getSubjectDN().getName(),
                        "Designation: Senior Software Developer",
                        "Department: " + certClient.getIssuerDN().getName(),
                        "Date: " + (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()))
                });

                sap.setSignatureGraphic(Image.getInstance(byteImage));
                sap.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
                sap.setVisibleSignature(rectangle, 1, null);

                ExternalSignature signature = new PrivateKeySignature(privateKey, "SHA-1", provider.getName());
                //MakeSignature.signDetached(sap,null, signature, chain, null, null, null, 0, MakeSignature.CryptoStandard.CMS);
               // MakeSignature.signDetached(sap, externalDigest, externalSignature, chain, crlList, ocspClient, tsaClient, estimatedSize, cryptoStandard);


                stamper.close();

                signedDocument = os.toByteArray();
                os.close();
                reader.close();

                String inFileName = outFilePath + "Signed_" + rendome_txn + ".pdf";
                FileOutputStream fileOutputStream = new FileOutputStream(inFileName);
                fileOutputStream.write(signedDocument);
                fileOutputStream.close();
            } else {
                System.out.println("No certificate found.");
            }

            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Replace this method with your signature image creation logic
    private static byte[] getSignature(String[] signatureText) {
        // Implement your signature image creation logic here
        // You can use external libraries or draw the signature image programmatically
        // and return it as a byte array.
        return new byte[0];
    }
}

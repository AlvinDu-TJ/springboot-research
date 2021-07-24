package sl.springboot.test.certificate;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class CertificateTest {

    public static void main(String[] args) throws KeyStoreException, IOException,
            NoSuchAlgorithmException, UnrecoverableKeyException, CertificateException {
        String keyStorePath = "E:/client_01.p12";
        String password = "123456";

        // 实例化密钥库，默认JKS类型
        KeyStore ks = KeyStore.getInstance("PKCS12");
        // 获得密钥库文件流
        FileInputStream is = new FileInputStream(keyStorePath);
        // 加载密钥库
        ks.load(is, password.toCharArray());
        // 关闭密钥库文件流
        is.close();

        //私钥
        Enumeration aliases = ks.aliases();
        String keyAlias = null;
        if (aliases.hasMoreElements()){
            keyAlias = (String)aliases.nextElement();
            System.out.println("p12's alias----->"+keyAlias);
        }
        PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, password.toCharArray());
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        System.out.println("私钥------------->" + privateKeyStr);

        //公钥
        Certificate certificate = ks.getCertificate(keyAlias);
        String publicKeyStr = Base64.encodeBase64String(certificate.getPublicKey().getEncoded());
        System.out.println("公钥------------->"+publicKeyStr);
    }
}

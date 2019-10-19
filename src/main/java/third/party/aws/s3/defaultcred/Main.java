package third.party.aws.s3.defaultcred;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class Main {

    private AmazonS3Client s3Client;
    private String bucketName;

    /**
     * The default credential profiles file– typically located at ~/.aws/credentials (location can vary per platform),
     * and shared by many of the AWS SDKs and by the AWS CLI. The AWS SDK for Java uses the ProfileCredentialsProvider
     * to load these credentials.
     */
    @Before
    public void setup() {
        s3Client = (AmazonS3Client) AmazonS3ClientBuilder.defaultClient();
        bucketName = "REPLACE HERE";
    }

    /**
     * Uploads a File with key to the AWS bucket
     */
    @Test
    public void uploadFile() {
        String key = "key"; // the specified key name of the file
        File file = new File("Replace here");
        s3Client.putObject(new PutObjectRequest(bucketName, key, file));
//        TODO commented out statement returns https but it isn't secure
//        return amazonS3Client.getResourceUrl(bucketName, keyName);
        // url of file uploaded, null if upload failed
        System.out.println("https://s3.amazonaws.com/" + bucketName + "/" + key);
    }

    /**
     * Delete file from AWS bucket by key
     */
    @Test
    public void deleteFile() {
        String key = "key"; // the specified key name of the file
        s3Client.deleteObject(bucketName, key);
    }
}

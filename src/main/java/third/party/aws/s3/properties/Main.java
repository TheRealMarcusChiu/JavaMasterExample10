package third.party.aws.s3.properties;

import third.party.aws.AWSPropertiesConfig;
import com.amazonaws.services.s3.model.S3Object;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Properties;

public class Main {

    private S3BucketClient s3BucketClient;

    @Before
    public void setup() {
        Properties properties = AWSPropertiesConfig.getProperties();
        String accessKey = properties.getProperty("aws.auth.accessKey");
        String secretKey = properties.getProperty("aws.auth.secretKey");
        String bucket = properties.getProperty("aws.bucketName");
        String bucketURL = properties.getProperty("aws.bucket.url");
        s3BucketClient = new S3BucketClient(accessKey, secretKey, bucket, bucketURL);
    }

    @Test
    public void upload() {
        String keyName = "sample";
        File file = getFileFromResource("JesusChrist.jpg");
        String url = s3BucketClient.uploadFile(keyName, file);
        System.out.println("url: " + url);
    }

    @Test
    public void getAndSave() {
        String keyName = "sample";
        S3Object s3Object = s3BucketClient.getFile(keyName);

        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";
        String targetPath = resourceFolder + "aws_object_copy.jpg";
        s3BucketClient.saveS3Object(s3Object, targetPath);
    }

    @Test
    public void delete() {
        String keyName = "sample";
        s3BucketClient.deleteFile(keyName);
    }

    /**
     * Reads from the Resource Folder based on the String path
     * @param path - root from resource folder
     * @return File
     */
    public File getFileFromResource(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(path).getFile());
    }
}

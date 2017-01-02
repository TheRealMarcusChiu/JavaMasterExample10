package aws.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class S3BucketClient {

    private AmazonS3 amazonS3;

    private String bucket;

    private String bucketURL;

    public S3BucketClient(String accessKey, String secretKey, String bucket, String bucketURL) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        amazonS3 = new AmazonS3Client(awsCredentials);
        this.bucket = bucket;
        this.bucketURL = bucketURL;
    }

    /**
     * Uploads a File with key name to the AWS bucket
     * @param keyName - the specified key name of the file
     * @param file - the file
     * @return String - url of file uploaded, null if upload failed
     */
    public String uploadFile(String keyName, File file) {
        String url = null;

        if(keyName != null && file != null) {
            try {
                amazonS3.putObject(new PutObjectRequest(bucket, keyName, file));
                url = bucketURL + keyName;
            } catch (AmazonServiceException ase) {
                // Uncomment for debugging purposes
            /*System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());*/
            } catch (AmazonClientException ace) {
                // Uncomment for debugging purposes
            /*System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());*/
            }
        }

        return url;
    }

    /**
     * get S3Object from AWS bucket
     * @param key
     * @return
     */
    public S3Object getFile(String key) {
        S3Object s3Object = null;

        try {
            System.out.println("Downloading an object");
            s3Object = amazonS3.getObject(new GetObjectRequest(bucket, key));
            System.out.println("Content-Type: "  + s3Object.getObjectMetadata().getContentType());

            // Get a range of bytes from an object.
//            GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucket, key);
//            rangeObjectRequest.setRange(0, 10);
//            S3Object objectPortion = amazonS3.getObject(rangeObjectRequest);

            System.out.println("Printing bytes retrieved.");
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which" +
                    " means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means"+
                    " the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }

        return s3Object;
    }

    /**
     * Delete file from AWS bucket by keyName
     * @param keyName - the keyName
     */
    public void deleteFile(String keyName) {
        amazonS3.deleteObject(bucket, keyName);
    }

    /**
     *
     * @param s3Object
     * @param path
     * @return Boolean
     */
    public Boolean saveS3Object(S3Object s3Object, String path) {
        Boolean success = false;

        File file = new File(path);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            IOUtils.copy(s3Object.getObjectContent(), outputStream);
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }
}

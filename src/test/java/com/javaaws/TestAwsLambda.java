package com.javaaws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.javaaws.service.AwsLambdaService;
import org.junit.Test;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: pxp167
 * @Date: 12/18/2018
 *
 */
public class TestAwsLambda {

    @Test
    public void testAwsResurceService(){
        AwsLambdaService awsLambdaService=new AwsLambdaService();
        S3EventNotification s3EventNotification = S3EventNotification.parseJson(getResource("s3test.json"));
        S3Event event = new S3Event(s3EventNotification.getRecords());
        TestContext ctx = new TestContext();
        ctx.setFunctionName("LambdaForm");
        Context context = ctx;
        awsLambdaService.handleRequest(event,context);

    }

    public String getResource(String filePath) {
        String data = null;
        try {
            URI uri = this.getClass().getClassLoader().getResource(filePath)
              .toURI();
            data = new String(Files.readAllBytes(Paths.get(uri)),
              Charset.forName("utf-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

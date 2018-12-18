package com.javaaws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

/**
 * @Author: pxp167
 * @Date: 12/18/2018
 *
 */
public class AwsLambdaService implements RequestHandler<S3Event, String> {

    /**
     * handleRequest
     * @param s3Event
     * @param context
     * @return
     */
    public String handleRequest(S3Event s3Event, Context context) {

        context.getLogger().log(s3Event.toJson());



        return "success!!!";
    }
}

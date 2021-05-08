package com.jota.lambda.appgate;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.jota.lambda.LambdaLogin;
import com.jota.request.RequestLogin;
import com.jota.response.ResponseLogin;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaLoginTest {

    private static RequestLogin input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {
        LambdaLogin handler = new LambdaLogin();
        Context ctx = createContext();

        ResponseLogin output = handler.handleRequest(input, ctx);

       
    }
}

package com.github.cuter44.wxpay.reqs;

import com.github.cuter44.wxpay.WxpayException;
import com.github.cuter44.wxpay.WxpayProtocolException;
import com.github.cuter44.wxpay.resps.WxpayResponseBase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author joemsu 2017-02-22 下午3:56
 *         小程序请求支付签名
 */
public class RequestPayment extends WxpayRequestBase {

    private static final String TIME_STAMP = "timeStamp";

    private static final String PACKAGE = "package";

    private static final String SIGN_TYPE = "signType";

    public static final List<String> KEYS_PARAM_NAME = Arrays.asList(
            "appId",
            "nonceStr",
            "package",
            "signType",
            "timeStamp"
    );

    public RequestPayment(Properties prop) {
        super(prop);
    }


    public RequestPayment timeStamp() {
        super.setProperty(TIME_STAMP, System.currentTimeMillis() / 1000 + "");
        return this;
    }


    public RequestPayment setPackage(String packageString) {
        super.setProperty(PACKAGE, packageString);
        return this;
    }

    public RequestPayment setSignType(String signType) {
        super.setProperty(SIGN_TYPE, signType);
        return this;
    }

    @Override
    public RequestPayment build() {
        return this;
    }

    /**
     * sign
     * SUB-CLASS MUST IMPLEMENT THIS METHOD TO BE CALLBACKED.
     *
     * @throws UnsupportedOperationException if <code>sign_type</code> is other than <code>MD5</code>
     * @throws IllegalStateException         if <code>Key</code> or something else (related to algorithm) not found
     */
    @Override
    public RequestPayment sign() throws UnsupportedEncodingException, UnsupportedOperationException, IllegalStateException {

        super.signForRequestPayment(KEYS_PARAM_NAME);
        return(this);
    }

    /**
     * Extract URL to execute request on client
     */
    @Override
    public String toURL() throws UnsupportedOperationException {
        return null;
    }

    /**
     * Execute the constructed query
     */
    @Override
    public WxpayResponseBase execute() throws WxpayException, WxpayProtocolException, IOException {
        return null;
    }
}

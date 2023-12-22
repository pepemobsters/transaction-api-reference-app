package com.mastercard.developer.transactionapi.job;

import com.mastercard.developer.transactionapi.client.TransactionApiClient;
import com.mastercard.developer.transactionapi.client.model.BatchResponse;
import com.mastercard.developer.transactionapi.config.TransactionApiProperties;
import com.mastercard.developer.transactionapi.context.RequestContextManager;
import com.mastercard.developer.transactionapi.enums.FlowType;
import org.openapitools.client.model.ReversalresponseReversalResponseV02;
import org.springframework.stereotype.Service;

/**
 * Polls for reversal responses from the Transaction API.
 */
@Service
public class ReversalResponsePoller extends ResponsePoller<ReversalresponseReversalResponseV02> {

    public ReversalResponsePoller(RequestContextManager requestContextManager, TransactionApiClient transactionApiClient, TransactionApiProperties transactionApiProperties) {
        super(FlowType.REVERSAL, requestContextManager, transactionApiClient, transactionApiProperties);
    }

    @Override
    protected BatchResponse<ReversalresponseReversalResponseV02> getResponses() {
        return getTransactionApiClient().getReversalResponses();
    }

    @Override
    protected String toJson(ReversalresponseReversalResponseV02 payload) {
        return payload.toJson();
    }

}

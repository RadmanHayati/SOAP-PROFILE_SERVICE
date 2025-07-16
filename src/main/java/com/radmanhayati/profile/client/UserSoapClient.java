package com.radmanhayati.profile.client;

import com.radmanhayati.profile.soap.generated.GetUserRequest;
import com.radmanhayati.profile.soap.generated.GetUserResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class UserSoapClient extends WebServiceGatewaySupport {

    public GetUserResponse getUser(Long userId) {
        GetUserRequest request = new GetUserRequest();
        request.setUserId(userId);
        return (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}

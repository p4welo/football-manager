package pl.fm.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by parado on 2014-11-24.
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/fmSocket").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(
            final ChannelRegistration registration) {
    }

    @Override
    public void configureClientOutboundChannel(
            final ChannelRegistration registration) {
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
    }
}
package cl.bci.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    WebSecurityConfig() {
    }

    protected void configure(HttpSecurity http) throws Exception {
        ((AuthorizedUrl) ((AuthorizedUrl) ((AuthorizedUrl) ((AuthorizedUrl) ((HttpSecurity)
                http.csrf().disable())
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(new String[]{"/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**", "/token"}))
                .permitAll()
                .antMatchers(new String[]{"/user"}))).denyAll().anyRequest()).authenticated();
        http.headers().frameOptions().disable();
    }
}

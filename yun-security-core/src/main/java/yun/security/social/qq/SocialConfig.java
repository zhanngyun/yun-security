package yun.security.social.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import yun.security.properties.SecurityProperties;

import javax.sql.DataSource;

/**
 * @Author: yzhang
 * @Date: 2018/3/9 17:54
 */
@Configuration
@EnableSocial
public class SocialConfig  extends SocialConfigurerAdapter{


    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("yun_");
        if(connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }
}

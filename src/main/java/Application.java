import com.dropwizard.demo.configuration.ApplicationConfiguration;
import com.dropwizard.demo.configuration.ApplicationHealthCheck;
import com.dropwizard.demo.repository.BrandRepository;
import com.dropwizard.demo.resource.BrandResource;
import com.dropwizard.demo.util.DBUtil;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.sql.DataSource;

public class Application extends io.dropwizard.Application<ApplicationConfiguration> {

    public static final String HEALTH_CHECK = "health check";
    public static void main(String[] args) throws Exception {
        new Application().run(args[0], args[1]);
    }
    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {

        DataSource datasource = DBUtil.getDataSource(applicationConfiguration.getDbConfiguration());
        BrandRepository brandRepository = new BrandRepository(datasource);
        BrandResource brandResource = new BrandResource( brandRepository);

        environment
                .jersey()
                .register(brandResource);

        environment.healthChecks().register(HEALTH_CHECK,new ApplicationHealthCheck());
    }
    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }

}
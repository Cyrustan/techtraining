import db.Investor;
import db.InvestorDAO;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.InvestorResource;

/**
 * Created by Moe on 2/10/18.
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

    private final HibernateBundle<DropwizardConfiguration> hibernate =
            new HibernateBundle<DropwizardConfiguration>(Investor.class) {

        public DataSourceFactory getDataSourceFactory(DropwizardConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new InvestorResource(new InvestorDAO(hibernate.getSessionFactory())));
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }


}

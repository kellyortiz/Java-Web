package Projeto;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApp extends Application<Configuration> {
    
    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/site", "/", "index.html"));
    }
    
    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[] { "server" });
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        CarrosDao dao = new CarrosDao(new ConexaoJavaDb("projeto", "projeto", "jdbc:derby://localhost", 1527, "Projeto"));
        environment.jersey().register(new CarrosResource(dao));
        environment.jersey().setUrlPattern("/api/*");
 
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new JogoDAO());

}


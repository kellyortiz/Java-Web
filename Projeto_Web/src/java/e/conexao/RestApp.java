package java.e.conexao;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.e.conexao.CarrosResource;

public class RestApp extends Application<Configuration> {
    
    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/html", "/", "index.html"));
    }
    
    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[] { "server" });
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new CarrosResource());
        environment.jersey().setUrlPattern("/api/*");
    }
}

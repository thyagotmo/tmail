package config;

import javax.jws.WebService;
import mgt.cadastro.impl.FactoryCadastroMgt;
import mgt.email.impl.FactoryEmailMgt;
import mgt.login.impl.FactoryLoginMgt;
import sistema.kernel.cadastro.impl.FactoryCadastro;
import sistema.kernel.email.impl.FactoryEmail;
import sistema.kernel.login.impl.FactoryLogin;

/**
 * Classe Config - responsável pela configuração dos componentes e do hibernate
 *
 * @author Thyago
 * @version 1 - 13/04/2012
 */
@WebService(endpointInterface = "config.IInitServer")
public class Config implements IInitServer {

    private boolean configComponents = false;
    public static boolean singleton = false;
    public static Config config;

    public Config() {
    }

    public static Config getInstance() {

        if (!singleton) {
            config = new Config();
            singleton = true;
        }

        return config;

    }

    @Override
    public boolean initServer() {

        if (!configComponents) {
            configLogin();
            configLoginMgt();
            configEmail();
            configEmailMgt();
            configCadastro();

            configComponents = true;
        }

        return true;
    }

    private void configLogin() {
        sistema.kernel.login.spec.prov.IManager managerLogin = FactoryLogin.getManager();
        mgt.login.spec.prov.IManager managerLoginMgt = FactoryLoginMgt.getManager();

        managerLogin.setRequiredInterface("ILoginMgt", managerLoginMgt.getProvidedInterface("ILoginMgt"));

    }

    private void configCadastro() {
        sistema.kernel.cadastro.spec.prov.IManager managerCadastro = FactoryCadastro.getManager();
        mgt.cadastro.spec.prov.IManager managerCadastroMgt = FactoryCadastroMgt.getManager();
        sistema.kernel.email.spec.prov.IManager managerEmail = FactoryEmail.getManager();
        

        managerCadastro.setRequiredInterface("ICadastroMgt", managerCadastroMgt.getProvidedInterface("ICadastroMgt"));
        managerCadastro.setRequiredInterface("IPaste", managerEmail.getProvidedInterface("IPaste"));
    }

    private void configLoginMgt() {
        mgt.login.spec.prov.IManager managerLoginMgt = FactoryLoginMgt.getManager();
        mgt.cadastro.spec.prov.IManager managerCadastroMgt = FactoryCadastroMgt.getManager();


        managerLoginMgt.setRequiredInterface("ICadastroMgt", managerCadastroMgt.getProvidedInterface("ICadastroMgt"));
    }

    private void configEmail() {
        sistema.kernel.email.spec.prov.IManager managerEmail = FactoryEmail.getManager();
        mgt.email.spec.prov.IManager managerEmailMgt = FactoryEmailMgt.getManager();
        mgt.cadastro.spec.prov.IManager managerCadastroMgt = FactoryCadastroMgt.getManager();

        managerEmail.setRequiredInterface("IEmailMgt", managerEmailMgt.getProvidedInterface("IEmailMgt"));
        managerEmail.setRequiredInterface("ICadastroMgt", managerCadastroMgt.getProvidedInterface("ICadastroMgt"));
        managerEmail.setRequiredInterface("IPasteMgt", managerEmailMgt.getProvidedInterface("IPasteMgt"));

    }

    private void configEmailMgt() {
        mgt.email.spec.prov.IManager managerEmailMgt = FactoryEmailMgt.getManager();
        mgt.cadastro.spec.prov.IManager managerCadastroMgt = FactoryCadastroMgt.getManager();

        managerEmailMgt.setRequiredInterface("ICadastroMgt", managerCadastroMgt.getProvidedInterface("ICadastroMgt"));
    }
}

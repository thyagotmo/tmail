package mgt.cadastro.impl;

import mgt.cadastro.spec.prov.ICadastroMgt;
import tmail.model.ont.User;

class FacadeICadastroMgt implements ICadastroMgt, sistema.kernel.cadastro.spec.req.ICadastroMgt,
        mgt.login.spec.req.ICadastroMgt, mgt.email.spec.req.ICadastroMgt, sistema.kernel.email.spec.req.ICadastroMgt {

    private CadastroMgtImpl cadastroMgtImpl;

    public FacadeICadastroMgt() {
        cadastroMgtImpl = new CadastroMgtImpl();
    }

    @Override
    public User createUser(String idUser) {
        return cadastroMgtImpl.createUser(idUser);
    }

    @Override
    public User updateUser(User user) {
        return cadastroMgtImpl.updateUser(user);
    }

    @Override
    public boolean deleteUser(String idUser) {
        return cadastroMgtImpl.deleteUser(idUser);
    }

    @Override
    public User getUser(String idUser) {
        return cadastroMgtImpl.getUser(idUser);
    }
}

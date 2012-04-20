
package sistema.wscomunicator.iemail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sistema.wscomunicator.iemail package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreatePaste_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "createPaste");
    private final static QName _DeletePasteResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "deletePasteResponse");
    private final static QName _GetReceivedEmailsFromUserByUserResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getReceivedEmailsFromUserByUserResponse");
    private final static QName _GetEmail_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getEmail");
    private final static QName _GetAllPastesByUserResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getAllPastesByUserResponse");
    private final static QName _GetEmailsByPasteResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getEmailsByPasteResponse");
    private final static QName _DeletePaste_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "deletePaste");
    private final static QName _GetEmailResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getEmailResponse");
    private final static QName _DeleteEmailResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "deleteEmailResponse");
    private final static QName _GetReceivedEmailsByUser_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getReceivedEmailsByUser");
    private final static QName _SendEmail_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "sendEmail");
    private final static QName _GetPaste_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getPaste");
    private final static QName _GetSentEmailsByUserResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getSentEmailsByUserResponse");
    private final static QName _GetSentEmailsFromUserByUserResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getSentEmailsFromUserByUserResponse");
    private final static QName _GetReceivedEmailsByUserResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getReceivedEmailsByUserResponse");
    private final static QName _GetReceivedEmailsFromUserByUser_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getReceivedEmailsFromUserByUser");
    private final static QName _GetSentEmailsByUser_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getSentEmailsByUser");
    private final static QName _GetEmailsByPaste_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getEmailsByPaste");
    private final static QName _GetAllPastesByUser_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getAllPastesByUser");
    private final static QName _GetSentEmailsFromUserByUser_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getSentEmailsFromUserByUser");
    private final static QName _DeleteEmail_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "deleteEmail");
    private final static QName _SendEmailResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "sendEmailResponse");
    private final static QName _GetPasteResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "getPasteResponse");
    private final static QName _CreatePasteResponse_QNAME = new QName("http://prov.spec.email.kernel.sistema/", "createPasteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sistema.wscomunicator.iemail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPastesByUserResponse }
     * 
     */
    public GetAllPastesByUserResponse createGetAllPastesByUserResponse() {
        return new GetAllPastesByUserResponse();
    }

    /**
     * Create an instance of {@link GetEmailsByPasteResponse }
     * 
     */
    public GetEmailsByPasteResponse createGetEmailsByPasteResponse() {
        return new GetEmailsByPasteResponse();
    }

    /**
     * Create an instance of {@link DeletePaste }
     * 
     */
    public DeletePaste createDeletePaste() {
        return new DeletePaste();
    }

    /**
     * Create an instance of {@link GetEmailResponse }
     * 
     */
    public GetEmailResponse createGetEmailResponse() {
        return new GetEmailResponse();
    }

    /**
     * Create an instance of {@link DeleteEmailResponse }
     * 
     */
    public DeleteEmailResponse createDeleteEmailResponse() {
        return new DeleteEmailResponse();
    }

    /**
     * Create an instance of {@link CreatePaste }
     * 
     */
    public CreatePaste createCreatePaste() {
        return new CreatePaste();
    }

    /**
     * Create an instance of {@link DeletePasteResponse }
     * 
     */
    public DeletePasteResponse createDeletePasteResponse() {
        return new DeletePasteResponse();
    }

    /**
     * Create an instance of {@link GetReceivedEmailsFromUserByUserResponse }
     * 
     */
    public GetReceivedEmailsFromUserByUserResponse createGetReceivedEmailsFromUserByUserResponse() {
        return new GetReceivedEmailsFromUserByUserResponse();
    }

    /**
     * Create an instance of {@link GetEmail }
     * 
     */
    public GetEmail createGetEmail() {
        return new GetEmail();
    }

    /**
     * Create an instance of {@link GetSentEmailsFromUserByUser }
     * 
     */
    public GetSentEmailsFromUserByUser createGetSentEmailsFromUserByUser() {
        return new GetSentEmailsFromUserByUser();
    }

    /**
     * Create an instance of {@link DeleteEmail }
     * 
     */
    public DeleteEmail createDeleteEmail() {
        return new DeleteEmail();
    }

    /**
     * Create an instance of {@link SendEmailResponse }
     * 
     */
    public SendEmailResponse createSendEmailResponse() {
        return new SendEmailResponse();
    }

    /**
     * Create an instance of {@link GetPasteResponse }
     * 
     */
    public GetPasteResponse createGetPasteResponse() {
        return new GetPasteResponse();
    }

    /**
     * Create an instance of {@link CreatePasteResponse }
     * 
     */
    public CreatePasteResponse createCreatePasteResponse() {
        return new CreatePasteResponse();
    }

    /**
     * Create an instance of {@link SendEmail }
     * 
     */
    public SendEmail createSendEmail() {
        return new SendEmail();
    }

    /**
     * Create an instance of {@link GetReceivedEmailsByUser }
     * 
     */
    public GetReceivedEmailsByUser createGetReceivedEmailsByUser() {
        return new GetReceivedEmailsByUser();
    }

    /**
     * Create an instance of {@link GetSentEmailsByUserResponse }
     * 
     */
    public GetSentEmailsByUserResponse createGetSentEmailsByUserResponse() {
        return new GetSentEmailsByUserResponse();
    }

    /**
     * Create an instance of {@link GetPaste }
     * 
     */
    public GetPaste createGetPaste() {
        return new GetPaste();
    }

    /**
     * Create an instance of {@link GetSentEmailsFromUserByUserResponse }
     * 
     */
    public GetSentEmailsFromUserByUserResponse createGetSentEmailsFromUserByUserResponse() {
        return new GetSentEmailsFromUserByUserResponse();
    }

    /**
     * Create an instance of {@link GetReceivedEmailsByUserResponse }
     * 
     */
    public GetReceivedEmailsByUserResponse createGetReceivedEmailsByUserResponse() {
        return new GetReceivedEmailsByUserResponse();
    }

    /**
     * Create an instance of {@link GetSentEmailsByUser }
     * 
     */
    public GetSentEmailsByUser createGetSentEmailsByUser() {
        return new GetSentEmailsByUser();
    }

    /**
     * Create an instance of {@link GetReceivedEmailsFromUserByUser }
     * 
     */
    public GetReceivedEmailsFromUserByUser createGetReceivedEmailsFromUserByUser() {
        return new GetReceivedEmailsFromUserByUser();
    }

    /**
     * Create an instance of {@link GetAllPastesByUser }
     * 
     */
    public GetAllPastesByUser createGetAllPastesByUser() {
        return new GetAllPastesByUser();
    }

    /**
     * Create an instance of {@link GetEmailsByPaste }
     * 
     */
    public GetEmailsByPaste createGetEmailsByPaste() {
        return new GetEmailsByPaste();
    }

    /**
     * Create an instance of {@link HashSet }
     * 
     */
    public HashSet createHashSet() {
        return new HashSet();
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link PasteDTO }
     * 
     */
    public PasteDTO createPasteDTO() {
        return new PasteDTO();
    }

    /**
     * Create an instance of {@link EmailDTO }
     * 
     */
    public EmailDTO createEmailDTO() {
        return new EmailDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePaste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "createPaste")
    public JAXBElement<CreatePaste> createCreatePaste(CreatePaste value) {
        return new JAXBElement<CreatePaste>(_CreatePaste_QNAME, CreatePaste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePasteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "deletePasteResponse")
    public JAXBElement<DeletePasteResponse> createDeletePasteResponse(DeletePasteResponse value) {
        return new JAXBElement<DeletePasteResponse>(_DeletePasteResponse_QNAME, DeletePasteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReceivedEmailsFromUserByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getReceivedEmailsFromUserByUserResponse")
    public JAXBElement<GetReceivedEmailsFromUserByUserResponse> createGetReceivedEmailsFromUserByUserResponse(GetReceivedEmailsFromUserByUserResponse value) {
        return new JAXBElement<GetReceivedEmailsFromUserByUserResponse>(_GetReceivedEmailsFromUserByUserResponse_QNAME, GetReceivedEmailsFromUserByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getEmail")
    public JAXBElement<GetEmail> createGetEmail(GetEmail value) {
        return new JAXBElement<GetEmail>(_GetEmail_QNAME, GetEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPastesByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getAllPastesByUserResponse")
    public JAXBElement<GetAllPastesByUserResponse> createGetAllPastesByUserResponse(GetAllPastesByUserResponse value) {
        return new JAXBElement<GetAllPastesByUserResponse>(_GetAllPastesByUserResponse_QNAME, GetAllPastesByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmailsByPasteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getEmailsByPasteResponse")
    public JAXBElement<GetEmailsByPasteResponse> createGetEmailsByPasteResponse(GetEmailsByPasteResponse value) {
        return new JAXBElement<GetEmailsByPasteResponse>(_GetEmailsByPasteResponse_QNAME, GetEmailsByPasteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePaste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "deletePaste")
    public JAXBElement<DeletePaste> createDeletePaste(DeletePaste value) {
        return new JAXBElement<DeletePaste>(_DeletePaste_QNAME, DeletePaste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getEmailResponse")
    public JAXBElement<GetEmailResponse> createGetEmailResponse(GetEmailResponse value) {
        return new JAXBElement<GetEmailResponse>(_GetEmailResponse_QNAME, GetEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "deleteEmailResponse")
    public JAXBElement<DeleteEmailResponse> createDeleteEmailResponse(DeleteEmailResponse value) {
        return new JAXBElement<DeleteEmailResponse>(_DeleteEmailResponse_QNAME, DeleteEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReceivedEmailsByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getReceivedEmailsByUser")
    public JAXBElement<GetReceivedEmailsByUser> createGetReceivedEmailsByUser(GetReceivedEmailsByUser value) {
        return new JAXBElement<GetReceivedEmailsByUser>(_GetReceivedEmailsByUser_QNAME, GetReceivedEmailsByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "sendEmail")
    public JAXBElement<SendEmail> createSendEmail(SendEmail value) {
        return new JAXBElement<SendEmail>(_SendEmail_QNAME, SendEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getPaste")
    public JAXBElement<GetPaste> createGetPaste(GetPaste value) {
        return new JAXBElement<GetPaste>(_GetPaste_QNAME, GetPaste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSentEmailsByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getSentEmailsByUserResponse")
    public JAXBElement<GetSentEmailsByUserResponse> createGetSentEmailsByUserResponse(GetSentEmailsByUserResponse value) {
        return new JAXBElement<GetSentEmailsByUserResponse>(_GetSentEmailsByUserResponse_QNAME, GetSentEmailsByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSentEmailsFromUserByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getSentEmailsFromUserByUserResponse")
    public JAXBElement<GetSentEmailsFromUserByUserResponse> createGetSentEmailsFromUserByUserResponse(GetSentEmailsFromUserByUserResponse value) {
        return new JAXBElement<GetSentEmailsFromUserByUserResponse>(_GetSentEmailsFromUserByUserResponse_QNAME, GetSentEmailsFromUserByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReceivedEmailsByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getReceivedEmailsByUserResponse")
    public JAXBElement<GetReceivedEmailsByUserResponse> createGetReceivedEmailsByUserResponse(GetReceivedEmailsByUserResponse value) {
        return new JAXBElement<GetReceivedEmailsByUserResponse>(_GetReceivedEmailsByUserResponse_QNAME, GetReceivedEmailsByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReceivedEmailsFromUserByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getReceivedEmailsFromUserByUser")
    public JAXBElement<GetReceivedEmailsFromUserByUser> createGetReceivedEmailsFromUserByUser(GetReceivedEmailsFromUserByUser value) {
        return new JAXBElement<GetReceivedEmailsFromUserByUser>(_GetReceivedEmailsFromUserByUser_QNAME, GetReceivedEmailsFromUserByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSentEmailsByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getSentEmailsByUser")
    public JAXBElement<GetSentEmailsByUser> createGetSentEmailsByUser(GetSentEmailsByUser value) {
        return new JAXBElement<GetSentEmailsByUser>(_GetSentEmailsByUser_QNAME, GetSentEmailsByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmailsByPaste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getEmailsByPaste")
    public JAXBElement<GetEmailsByPaste> createGetEmailsByPaste(GetEmailsByPaste value) {
        return new JAXBElement<GetEmailsByPaste>(_GetEmailsByPaste_QNAME, GetEmailsByPaste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPastesByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getAllPastesByUser")
    public JAXBElement<GetAllPastesByUser> createGetAllPastesByUser(GetAllPastesByUser value) {
        return new JAXBElement<GetAllPastesByUser>(_GetAllPastesByUser_QNAME, GetAllPastesByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSentEmailsFromUserByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getSentEmailsFromUserByUser")
    public JAXBElement<GetSentEmailsFromUserByUser> createGetSentEmailsFromUserByUser(GetSentEmailsFromUserByUser value) {
        return new JAXBElement<GetSentEmailsFromUserByUser>(_GetSentEmailsFromUserByUser_QNAME, GetSentEmailsFromUserByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "deleteEmail")
    public JAXBElement<DeleteEmail> createDeleteEmail(DeleteEmail value) {
        return new JAXBElement<DeleteEmail>(_DeleteEmail_QNAME, DeleteEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "sendEmailResponse")
    public JAXBElement<SendEmailResponse> createSendEmailResponse(SendEmailResponse value) {
        return new JAXBElement<SendEmailResponse>(_SendEmailResponse_QNAME, SendEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPasteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "getPasteResponse")
    public JAXBElement<GetPasteResponse> createGetPasteResponse(GetPasteResponse value) {
        return new JAXBElement<GetPasteResponse>(_GetPasteResponse_QNAME, GetPasteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePasteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://prov.spec.email.kernel.sistema/", name = "createPasteResponse")
    public JAXBElement<CreatePasteResponse> createCreatePasteResponse(CreatePasteResponse value) {
        return new JAXBElement<CreatePasteResponse>(_CreatePasteResponse_QNAME, CreatePasteResponse.class, null, value);
    }

}

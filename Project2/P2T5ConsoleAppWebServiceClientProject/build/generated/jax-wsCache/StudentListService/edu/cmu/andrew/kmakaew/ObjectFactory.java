
package edu.cmu.andrew.kmakaew;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.cmu.andrew.kmakaew package. 
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

    private final static QName _UpdateStudentResponse_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "updateStudentResponse");
    private final static QName _CreateStudent_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "createStudent");
    private final static QName _CreateStudentResponse_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "createStudentResponse");
    private final static QName _ReadStudent_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "readStudent");
    private final static QName _FindAllStudentNamesResponse_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "findAllStudentNamesResponse");
    private final static QName _Studenttable_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "studenttable");
    private final static QName _FindAllStudentNames_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "findAllStudentNames");
    private final static QName _ReadStudentResponse_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "readStudentResponse");
    private final static QName _UpdateStudent_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "updateStudent");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "deleteStudentResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://kmakaew.andrew.cmu.edu/", "deleteStudent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.cmu.andrew.kmakaew
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateStudentResponse }
     * 
     */
    public UpdateStudentResponse createUpdateStudentResponse() {
        return new UpdateStudentResponse();
    }

    /**
     * Create an instance of {@link FindAllStudentNames }
     * 
     */
    public FindAllStudentNames createFindAllStudentNames() {
        return new FindAllStudentNames();
    }

    /**
     * Create an instance of {@link Studenttable }
     * 
     */
    public Studenttable createStudenttable() {
        return new Studenttable();
    }

    /**
     * Create an instance of {@link FindAllStudentNamesResponse }
     * 
     */
    public FindAllStudentNamesResponse createFindAllStudentNamesResponse() {
        return new FindAllStudentNamesResponse();
    }

    /**
     * Create an instance of {@link ReadStudent }
     * 
     */
    public ReadStudent createReadStudent() {
        return new ReadStudent();
    }

    /**
     * Create an instance of {@link CreateStudentResponse }
     * 
     */
    public CreateStudentResponse createCreateStudentResponse() {
        return new CreateStudentResponse();
    }

    /**
     * Create an instance of {@link CreateStudent }
     * 
     */
    public CreateStudent createCreateStudent() {
        return new CreateStudent();
    }

    /**
     * Create an instance of {@link UpdateStudent }
     * 
     */
    public UpdateStudent createUpdateStudent() {
        return new UpdateStudent();
    }

    /**
     * Create an instance of {@link ReadStudentResponse }
     * 
     */
    public ReadStudentResponse createReadStudentResponse() {
        return new ReadStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "updateStudentResponse")
    public JAXBElement<UpdateStudentResponse> createUpdateStudentResponse(UpdateStudentResponse value) {
        return new JAXBElement<UpdateStudentResponse>(_UpdateStudentResponse_QNAME, UpdateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "createStudent")
    public JAXBElement<CreateStudent> createCreateStudent(CreateStudent value) {
        return new JAXBElement<CreateStudent>(_CreateStudent_QNAME, CreateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "createStudentResponse")
    public JAXBElement<CreateStudentResponse> createCreateStudentResponse(CreateStudentResponse value) {
        return new JAXBElement<CreateStudentResponse>(_CreateStudentResponse_QNAME, CreateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "readStudent")
    public JAXBElement<ReadStudent> createReadStudent(ReadStudent value) {
        return new JAXBElement<ReadStudent>(_ReadStudent_QNAME, ReadStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllStudentNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "findAllStudentNamesResponse")
    public JAXBElement<FindAllStudentNamesResponse> createFindAllStudentNamesResponse(FindAllStudentNamesResponse value) {
        return new JAXBElement<FindAllStudentNamesResponse>(_FindAllStudentNamesResponse_QNAME, FindAllStudentNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Studenttable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "studenttable")
    public JAXBElement<Studenttable> createStudenttable(Studenttable value) {
        return new JAXBElement<Studenttable>(_Studenttable_QNAME, Studenttable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllStudentNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "findAllStudentNames")
    public JAXBElement<FindAllStudentNames> createFindAllStudentNames(FindAllStudentNames value) {
        return new JAXBElement<FindAllStudentNames>(_FindAllStudentNames_QNAME, FindAllStudentNames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "readStudentResponse")
    public JAXBElement<ReadStudentResponse> createReadStudentResponse(ReadStudentResponse value) {
        return new JAXBElement<ReadStudentResponse>(_ReadStudentResponse_QNAME, ReadStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "updateStudent")
    public JAXBElement<UpdateStudent> createUpdateStudent(UpdateStudent value) {
        return new JAXBElement<UpdateStudent>(_UpdateStudent_QNAME, UpdateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kmakaew.andrew.cmu.edu/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

}

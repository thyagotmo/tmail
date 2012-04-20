package persistence.grow.ic.ufal.br.gkmt.codegen;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openrdf.elmo.codegen.OntologyConverter;

public class CodeGenerator {

	private String baseURI;

	private String baseURL;

	private String baseName;

	private Map<String, String> imports = new HashMap<String, String>();

	private OntologyConverter conv = new OntologyConverter();

	private String basePkgPath = "gmkt.codegen.";

	private File jarFile;

	public void setImports(Map<String, String> imports) {
		this.imports = imports;
		for (String s : imports.keySet()) {

			String ontologyName = "default";

			if (s.contains("/")) {
				ontologyName = s.substring(s.lastIndexOf("/") + 1);
			} else {
				System.err.println("Invalid Path Format");
			}

			bind(ontologyName.toLowerCase(), imports.get(s));
		}
	}

	public void setMainOntology(String ontologyURI, String ontologyURL) {

		if (ontologyURL.contains("/")) {
			this.baseName = ontologyURL
					.substring(ontologyURL.lastIndexOf("/") + 1);
		} else {
			System.err.println("Invalid URL Format");
		}

		this.baseURI = ontologyURI;
		this.baseURL = ontologyURL;

		bind(this.baseName.toLowerCase(), this.baseURI);

	}

	private void bind(String ontologyName, String ontologyURI) {
		this.conv.bindPackageToNamespace(this.basePkgPath + ontologyName,
				ontologyURI + "#");
	}

	public void setPathOutputJarFile(String path) {

		this.jarFile = new File(path);

		try {
			this.jarFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addAllRDFResources() {

		try {
			if (!this.baseURI.isEmpty()) {
				URL url = new URL(this.baseURL);
				this.conv.addRdfSource(url);
			} else {
				System.err.println("Ontology URI null");
			}

			if (!this.imports.isEmpty()) {

				for (String importURL : this.imports.keySet()) {
					URL u = new URL(importURL);
					this.conv.addRdfSource(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startCodeGenerator() {

		try {

			addAllRDFResources();

			this.conv.init();

			this.conv.createClasses(this.jarFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

            Map<String, String> imports = new HashMap<String, String>();
            imports.put("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.CP.owl",
                    "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.CP.owl");
            imports.put("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Curriculum.owl",
                    "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Curriculum.owl");
            imports.put("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Resource.owl",
                    "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Resource.owl");
            imports.put("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.owl",
                    "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Instances.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Instances.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Pedagogical/MASSAYO.Pedagogical.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Pedagogical/MASSAYO.Pedagogical.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Pedagogical/MASSAYO.Pedagogical.Instances.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Pedagogical/MASSAYO.Pedagogical.Instances.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Goal.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Goal.owl");
//            imports.put("http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Interaction.Cognitive.owl",
//                    "http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Interaction.Cognitive.owl");
            
            CodeGenerator g = new CodeGenerator();

//            g.setMainOntology("http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Instances.owl#",
//                    "http://grow04-servidor/owl/MASSAYO/Student/MASSAYO.Learner.Instances.owl");
            g.setMainOntology("http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Instances.owl",
                     "http://grow04-servidor/owl/MASSAYO/Domain/MASSAYO.Domain.Instances.owl");
            g.setPathOutputJarFile("/home/jean/OntologiesOneJar.jar");
            g.setImports(imports);
            g.startCodeGenerator();

	}

}
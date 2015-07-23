package com.testing;

import java.util.Collection;

import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Company;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
        	System.out.println("Inside the Drools Testing " ) ;
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	    
    	    Collection<KiePackage> kiePkgs = kContainer.getKieBase("rules").getKiePackages() ;
    	    System.out.println("kiePkgs Length is " + kiePkgs.size() ) ;
    	    for(KiePackage kiePkg : kiePkgs) {
    	    	System.out.println("Package Name is --->" + kiePkg.getName() ) ;
    	    	
    	    	Collection<Rule>  rules = kiePkg.getRules() ;
    	    	
    	    	for (Rule rule : rules) {
    	    		System.out.println("Rule Name is --->" + rule.getName() )  ;
    	    	}
    	    	
    	    }
    	    
    	    
//    	    FileInputStream fileInputStream=null;
//    	    
//            File file = new File("com/sample/RecTemplate.template");
//     
//            byte[] bFile = new byte[(int) file.length()];
//     
//            try {
//                //convert file into array of bytes
//    	    fileInputStream = new FileInputStream(file);
//    	    fileInputStream.read(bFile);
//    	    fileInputStream.close();
//     
//    	    for (int i = 0; i < bFile.length; i++) {
//    	       	System.out.print((char)bFile[i]);
//                }
//     
//    	    System.out.println("Done");
//            }catch(Exception e){
//            	e.printStackTrace();
//            }

//    	    GuidedRuleTemplateConverter  converter  = new GuidedRuleTemplateConverter() ;
//    	    byte[] result = converter.convert("RecTemplate", bFile).getContent() ; 
    	    
//    	    System.out.println(result) ; 
    	    
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            Company  company  = new Company() ;
            company.setCompanyId("12345") ;
            company.setCompanyName("CompanyName") ;
            
            kSession.insert(company) ; 
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}

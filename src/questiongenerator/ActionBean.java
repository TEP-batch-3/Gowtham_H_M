package questiongenerator;

public class ActionBean {

	private static String entity_id;
	private static String entity_title;
	private static int  entity_usage;
	private static String concept_id;
	private static String concept_title;
	private static boolean  concept_scenario_driven;
	private static boolean  concept_enetiy_driven;
	private static boolean concept_operation_driven;
	private static String operation_id;
	private static String  operation_title;
	private static String  field_id;
	private static String field_title;
	     
	     public static  String getentity_title() {
		        return entity_title;
			}
		     public  void setentity_title(String newentity_title) {
		    	 entity_title = newentity_title;
			}
		     
		     public static  int getentity_usage() {
			        return entity_usage;
				}
			     public static  void setentity_usage(int newentity_usage) {
			    	 entity_usage = newentity_usage;
				}
			     	     
		     
		     public static  String getconcept_title() { 
		    	 return concept_title;
			        
				}

			     public void setconcept_title(String newconcept_title) {
			    	 concept_title = newconcept_title;
				}	
			     public boolean getconcept_scenario_driven() {
				        return concept_scenario_driven;
					}

				     public  void setconcept_scenario_driven(boolean newconcept_scenario_driven) {
				    	 concept_scenario_driven = newconcept_scenario_driven;
					}
				     public  boolean getconcept_enetiy_driven() {
					        return concept_enetiy_driven;
						}

					     public void setconcept_enetiy_driven(boolean newconcept_enetiy_driven) {
					    	 concept_enetiy_driven = newconcept_enetiy_driven;
						}
					     public  boolean getconcept_operation_driven() {
						        return concept_operation_driven;
							}

						     public  void setconcept_operation_driven(boolean newconcept_operation_driven) {
						    	 concept_operation_driven = newconcept_operation_driven;
							}
		  
						     public static  String getoperation_title() {
				        return operation_title;
					}

				     public  static void setoperation_title(String newoperation_title) {
				    	 operation_title = newoperation_title;
					}

				     public  static String getfield_title() {
					        return field_title;
						}

					     public static  void setfield_title(String newfield_title) {
					    	 field_title = newfield_title;
						}
						public void setentity_usage(String parameter) {
							// TODO Auto-generated method stub
							
						}
}

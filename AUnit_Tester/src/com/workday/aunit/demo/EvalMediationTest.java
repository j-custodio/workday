package com.workday.aunit.demo;

import com.workday.aunit.AssemblyTestCase;
import com.workday.aunit.annotations.AssemblyTest;
import com.workday.aunit.annotations.AssertAfter;
import com.workday.aunit.annotations.UnitTest;

@AssemblyTest(project = "AUnit_Tester")
public class EvalMediationTest extends AssemblyTestCase{
	@UnitTest(startComponent = "Eval-Validation")
	public void testEvalMediation() throws Exception {
		setMessagePart(0, "test/simple-input.xml", "text/xml");
		
	}
	
	@AssertAfter (id = "Eval-Validation", step="Eval")
	public void verifyEvalMediation() throws Exception {
		
        assertTrue(compare(
                getTestResourceInputStream("test/simple-expected.xml"), 
                "text/xml", 
                (InputStream) getMediationContext().getMessage().getMessagePart(0, InputStream.class), 
                "text/xml", 
                Comparator.dom));

				

	}
}

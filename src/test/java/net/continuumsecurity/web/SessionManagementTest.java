package net.continuumsecurity.web;

import org.testng.annotations.*;
import net.continuumsecurity.web.steps.WebApplicationSteps;
import org.jbehave.core.model.ExamplesTable;
import net.continuumsecurity.web.NgUtils;
import java.lang.System;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class SessionManagementTest {
  protected WebApplicationSteps webAppSteps = new WebApplicationSteps();
  ExamplesTable credentialsTable;
  
  @BeforeClass
  public void setUp() {
    webAppSteps.createApp();
    String workingDirectory = System.getProperty("user.dir");
    this.credentialsTable = new ExamplesTable(NgUtils.createStringFromJBehaveTable(workingDirectory+"/src/main/stories/users.table"));
  }
  
  @BeforeTest
  public void beforeScenario() {
    webAppSteps.createAppAndCredentials();
  }

  @Test
  public void the_session_ID_should_be_changed_after_authentication(){
    webAppSteps.openLoginPage();
    webAppSteps.getSessionIds();
    webAppSteps.loginFromTable(this.credentialsTable);
    webAppSteps.compareSessionIds();
  }
  
  @Test
  public void when_the_user_logs_out_then_the_session_should_no_longer_be_valid(){
    webAppSteps.loginFromTable(this.credentialsTable);
    webAppSteps.logout();
    webAppSteps.loginFails();
  }
  
  @Test
  public void sessions_should_timeout_after_a_period_of_inactivity(){
    webAppSteps.loginFromTable(this.credentialsTable);
    System.out.println("Missing And the session is inactive for 30 minutes step definition");
  }
  
  @Test
  public void the_session_cookie_should_have_the_secure_flag_set(){
    webAppSteps.loginFromTable(this.credentialsTable);
    webAppSteps.getSessionIds();
    webAppSteps.sessionCookiesSecureFlag();
  }
  
  @Test
  public void the_session_cookie_should_have_the_httpOnly_flag_set(){
    webAppSteps.setProxyDriver();
    webAppSteps.resetProxy();
    webAppSteps.loginFromTable(this.credentialsTable);
    webAppSteps.sessionCookiesHttpOnlyFlag();
  }

}

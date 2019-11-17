<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TAccount Detail</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TAccount Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdAccount:"/>
                    <h:outputText value="#{tAccount.TAccount.idAccount}" title="IdAccount" />
                    <h:outputText value="Balance:"/>
                    <h:outputText value="#{tAccount.TAccount.balance}" title="Balance" />
                    <h:outputText value="IdStatus:"/>
                    <h:outputText value="#{tAccount.TAccount.idStatus}" title="IdStatus" />
                    <h:outputText value="CreatedAt:"/>
                    <h:outputText value="#{tAccount.TAccount.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="IdUser:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tAccount.TAccount.idUser}"/>
                        <h:panelGroup rendered="#{tAccount.TAccount.idUser != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TUser.detailSetup}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount.idUser][TUser.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TUser.editSetup}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount.idUser][TUser.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TUser.destroy}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTUser" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount.idUser][TUser.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAccount"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="TMovementCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tAccount.TAccount.TMovementCollection}" value="(No Items)"/>
                        <h:dataTable value="#{tAccount.TAccount.TMovementCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tAccount.TAccount.TMovementCollection}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdMovement"/>
                                </f:facet>
                                <h:outputText value="#{item.idMovement}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Description"/>
                                </f:facet>
                                <h:outputText value="#{item.description}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Val"/>
                                </f:facet>
                                <h:outputText value="#{item.val}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FinalBalance"/>
                                </f:facet>
                                <h:outputText value="#{item.finalBalance}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CreatedAt"/>
                                </f:facet>
                                <h:outputText value="#{item.createdAt}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdAccount"/>
                                </f:facet>
                                <h:outputText value="#{item.idAccount}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tMovement.detailSetup}">
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAccount" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tMovement.editSetup}">
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAccount" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tMovement.destroy}">
                                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAccount" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TAccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{TAccount.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TAccount.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAccount.TAccount][tAccount.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TAccount.createSetup}" value="New TAccount" />
                <br />
                <h:commandLink action="#{TAccount.listSetup}" value="Show All TAccount Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>

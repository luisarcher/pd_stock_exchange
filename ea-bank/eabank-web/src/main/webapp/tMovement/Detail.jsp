<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TMovement Detail</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TMovement Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdMovement:"/>
                    <h:outputText value="#{tMovement.TMovement.idMovement}" title="IdMovement" />
                    <h:outputText value="Description:"/>
                    <h:outputText value="#{tMovement.TMovement.description}" title="Description" />
                    <h:outputText value="Val:"/>
                    <h:outputText value="#{tMovement.TMovement.val}" title="Val" />
                    <h:outputText value="FinalBalance:"/>
                    <h:outputText value="#{tMovement.TMovement.finalBalance}" title="FinalBalance" />
                    <h:outputText value="CreatedAt:"/>
                    <h:outputText value="#{tMovement.TMovement.createdAt}" title="CreatedAt" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="IdAccount:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tMovement.TMovement.idAccount}"/>
                        <h:panelGroup rendered="#{tMovement.TMovement.idAccount != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TAccount.detailSetup}">
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement.idAccount][TAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tMovement"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TMovementController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TAccount.editSetup}">
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement.idAccount][TAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tMovement"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TMovementController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TAccount.destroy}">
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement.idAccount][TAccount.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tMovement"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.isec.eabank.jsf.TMovementController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{TMovement.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TMovement.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tMovement.TMovement][tMovement.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TMovement.createSetup}" value="New TMovement" />
                <br />
                <h:commandLink action="#{TMovement.listSetup}" value="Show All TMovement Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>

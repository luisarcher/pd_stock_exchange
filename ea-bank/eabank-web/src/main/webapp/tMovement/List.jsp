<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TMovement Items</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TMovement Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TMovement Items Found)<br />" rendered="#{tMovement.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tMovement.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tMovement.pagingInfo.firstItem + 1}..#{tMovement.pagingInfo.lastItem} of #{tMovement.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tMovement.prev}" value="Previous #{tMovement.pagingInfo.batchSize}" rendered="#{tMovement.pagingInfo.firstItem >= tMovement.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tMovement.next}" value="Next #{tMovement.pagingInfo.batchSize}" rendered="#{tMovement.pagingInfo.lastItem + tMovement.pagingInfo.batchSize <= tMovement.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tMovement.next}" value="Remaining #{tMovement.pagingInfo.itemCount - tMovement.pagingInfo.lastItem}"
                                   rendered="#{tMovement.pagingInfo.lastItem < tMovement.pagingInfo.itemCount && tMovement.pagingInfo.lastItem + tMovement.pagingInfo.batchSize > tMovement.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tMovement.TMovementItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tMovement.editSetup}">
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tMovement.remove}">
                                <f:param name="jsfcrud.currentTMovement" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tMovement.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tMovement.createSetup}" value="New TMovement"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>

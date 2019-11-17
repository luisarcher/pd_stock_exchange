<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TAccount Items</title>
            <link rel="stylesheet" type="text/css" href="/eabank-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TAccount Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TAccount Items Found)<br />" rendered="#{tAccount.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tAccount.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tAccount.pagingInfo.firstItem + 1}..#{tAccount.pagingInfo.lastItem} of #{tAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAccount.prev}" value="Previous #{tAccount.pagingInfo.batchSize}" rendered="#{tAccount.pagingInfo.firstItem >= tAccount.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tAccount.next}" value="Next #{tAccount.pagingInfo.batchSize}" rendered="#{tAccount.pagingInfo.lastItem + tAccount.pagingInfo.batchSize <= tAccount.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAccount.next}" value="Remaining #{tAccount.pagingInfo.itemCount - tAccount.pagingInfo.lastItem}"
                                   rendered="#{tAccount.pagingInfo.lastItem < tAccount.pagingInfo.itemCount && tAccount.pagingInfo.lastItem + tAccount.pagingInfo.batchSize > tAccount.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tAccount.TAccountItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdAccount"/>
                            </f:facet>
                            <h:outputText value="#{item.idAccount}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Balance"/>
                            </f:facet>
                            <h:outputText value="#{item.balance}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdStatus"/>
                            </f:facet>
                            <h:outputText value="#{item.idStatus}"/>
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
                                <h:outputText value="IdUser"/>
                            </f:facet>
                            <h:outputText value="#{item.idUser}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tAccount.detailSetup}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tAccount.editSetup}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tAccount.remove}">
                                <f:param name="jsfcrud.currentTAccount" value="#{jsfcrud_class['com.isec.eabank.jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAccount.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tAccount.createSetup}" value="New TAccount"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>

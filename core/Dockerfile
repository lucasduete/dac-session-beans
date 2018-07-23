FROM payara/server-full

ENV APPNAME core
ENV DOMAIN domain1
ENV AUTODEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/

COPY target/${APPNAME}.war  ${AUTODEPLOY}

ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
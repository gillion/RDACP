#!/bin/sh

# USER_MEM_ARGS   - The variable to override the standard JVM arguments
USER_MEM_ARGS="-XX:MaxPermSize=256M -Xms256M -Xmx512M -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails  -XX:+PrintGCTimeStamps -Xloggc:/home/ap/crmc_spm/domains/crmc_spm/servers/AdminServer/logs/gc_AdminServer.log"

# JAVA_OPTIONS    - Java command-line options for running the server. (These
#                   will be tagged on to the end of the JAVA_VM and
#                   MEM_ARGS)
JAVA_OPTIONS="$JAVA_OPTIONS -Dweblogic.threadpool.MinPoolSize=20 -Dweblogic.threadpool.MaxPool Size=200"

# EXT_PRE_CLASSPATH   - The variable to add extensions classpath before default classpath
EXT_PRE_CLASSPATH=""

# EXT_POST_CLASSPATH   - The variable to add extensions classpath after default classpath
EXT_POST_CLASSPATH=""

export SADIR=${SADIR}
export LD_LIBRARY_PATH=$SADIR/lib64:$LD_LIBRARY_PATH
export LANG=zh_CN.UTF-8
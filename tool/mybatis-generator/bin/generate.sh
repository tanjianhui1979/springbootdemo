#!/bin/bash

# 获取项目根目录，并赋值给root变量
root=`dirname $0|cd; cd ../../..; pwd`

# 根据项目结构规则，获取目标项目目录，并赋值给targetProject变量。
# 注意：
# 1、根据项目的不同，规则也不同，需要对root与target的获取进行调整
# 2、该变量的值将用于替换generatorConfig.xml文件中的${targetProject}
targetProject=${root}/targetProject

# 如果targetProject目录不存在，则创建
[ -d ${targetProject} ] || mkdir -p ${targetProject}

classpath=${root}/tool/mybatis-generator/lib
confpath=${root}/tool/mybatis-generator/conf
logpath=${root}/tool/mybatis-generator/logs
classPathLocation=${classpath}/mysql-connector-java-5.1.24.jar

java -DclassPathLocation=${classPathLocation} \
     -DtargetProject=${targetProject} \
     -DgeneratorConfig.properties=${confpath}/generatorConfig.properties \
     -jar ${classpath}/mybatis-generator-core-1.3.2.jar \
     -configfile ${confpath}/generatorConfig.xml \
     -overwrite > ${logpath}/generate.log

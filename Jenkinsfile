node('Java'){
   def mvnHome
   def SonarQubeHome
   def version='V'+sh(script:"date +%Y%m%d%H%M%S",returnStdout: true).trim()
   stage('获取最新代码') { // for display purposes
      // Get some code from a GitHub repository
      git branch:'uat',url: 'https://github.com/Macintosh-c/Jenkins-Test.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'maven'
      SonarQubeHome = tool 'SonarQube'

   }

   stage('单元测试并生成报告') {
      // Run the maven builds
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean test surefire-report:report"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean test surefire-report:report/)
      }
      allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
      junit keepLongStdio: true, testResults: 'target/surefire-reports/*.xml'
   }
   stage('sonar代码检测并生成报告') {
       sh "'${SonarQubeHome}/bin/sonar-scanner' -Dsonar.host.url=http://172.16.98.166:9000 -Dsonar.login=admin -Dsonar.password=admin -Dsonar.java.binaries=target -Dsonar.sourceEncoding=UTF-8 -Dsonar.sources=src -Dsonar.projectKey=SonarTestdemo -Dsonar.projectName=SonarTestdemo -Dsonar.core.codeCoveragePlugin=jacoco -Dsonar.jacoco.reportPaths=target/jacoco.exec -Dsonar.projectVersion=${version}"
     //sh "'${mvnHome}/bin/mvn' sonar:sonar -Dsonar.host.url=http://172.16.98.166:9000 -Dsonar.login=admin -Dsonar.password=admin -Dsonar.java.binaries=target -Dsonar.sourceEncoding=UTF-8 -Dsonar.sources=src/main/java -Dsonar.projectKey=SonarTestdemo -Dsonar.projectName=SonarTestdemo -Dsonar.core.codeCoveragePlugin=jacoco -Dsonar.jacoco.reportPaths=target/jacoco.exec -Dsonar.projectVersion=1.0"
     //  if (isUnix()) {
     //    sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
     // } else {
     //    bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
     // }
     //bat(/"${SonarQubeHome}\bin\sonar-scanner" -Dsonar.host.url=http:\\127.0.0.1:9000 -Dsonar.java.binaries=target -Dsonar.sourceEncoding=UTF-8 -Dsonar.sources=src -Dsonar.projectKey=Sonardemo -Dsonar.projectName=Sonardemo -Dsonar.projectVersion=2.0/)
   }
   stage('checkstyle代码检测并生成报告') {
       if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' checkstyle:checkstyle"
      } else {
         bat(/"${mvnHome}\bin\mvn" checkstyle:checkstyle/)
      }
      checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/checkstyle-result.xml', unHealthy: ''
   }
   stage('构建项目') {
    sh "'${mvnHome}/bin/mvn' package -DskipTests"
   }

          stage('deploy') {
   //   sshPublisher(publishers: [sshPublisherDesc(configName: '172.16.98.194', sshCredentials: [encryptedPassphrase: '{AQAAABAAAAAQjzldaiQ8/XGqsGbSd7ngMvkxCS7JeKYxzMbZRFK5vDY=}', key: '', keyPath: '', username: 'stadmin'], transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''sudo systemctl status crsys-baidu.service
//echo \'1\'
//sudo systemctl stop crsys-baidu.service
//echo \'2\'
//sudo cp /home/stadmin/jenkins_home/workspace/DEV_Crsys/crsys-main/target/crsys-main.jar /opt/crsys-baidu/
//echo \'3\'
//sudo systemctl start crsys-baidu.service
//echo \'4\'
//sudo systemctl status crsys-baidu.service
//echo \'5\'''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
   }
    stage('Push DockerImage') {
sshPublisher(publishers: [sshPublisherDesc(configName: '172.16.98.177', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/opt/nielsen/demo', remoteDirectorySDF: false, removePrefix: 'docker/', sourceFiles: 'docker/Dockerfile'), sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd /opt/nielsen/demo
docker login --username=kaishen --password=Softtek.2019 172.16.98.177
docker build -t demo-jenkins .
docker tag demo-jenkins 172.16.98.177/nielsen/test:latest
docker push 172.16.98.177/nielsen/test:latest''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/opt/nielsen/demo', remoteDirectorySDF: false, removePrefix: 'target/', sourceFiles: 'target/demo-jenkins.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

//export demo_version="V`date +%Y%m%d%H%M%S`"
//docker tag demo-jenkins 172.16.98.177/nielsen/test:$demo_version
//docker push 172.16.98.177/nielsen/test:$demo_version
//docker rmi 172.16.98.177/nielsen/test:$demo_version
   }
}
pipeline {
  agent {
    kubernetes {
      label 'mypod'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: gradle
    image: gradle:latest
    command:
    - cat
    tty: true
  - name: maven
    image: maven:3.6.1-jdk-8-slim
    command:
    - cat
    tty: true
  - name: kaniko
    image: gcr.io/kaniko-project/executor:debug
    imagePullPolicy: Always
    command:
    - /busybox/cat
    tty: true
    volumeMounts:
      - name: jenkins-docker-cfg
        mountPath: /kaniko/.docker
  - name: helm
    image: lachlanevenson/k8s-helm:v2.12.3
    command:
    - cat
    tty: true

  volumes:
  - name: jenkins-docker-cfg
    projected:
      sources:
      - secret:
          name: docker-credentials
          items:
            - key: .dockerconfigjson
              path: config.json
"""
    }
  }

  environment {
    IMAGE = "demo-javarest-java-spring"
    VERSION = "0.0.1"
  }

  stages {
    stage('Build') {
      steps {
        container('gradle') {
          sh 'gradle build'
        }
      }
    }
    stage('Build Docker image with Kaniko') {
      steps {
        container(name: 'kaniko', shell: '/busybox/sh') {
          withEnv(['PATH+EXTRA=/busybox']) {
            sh '''#!/busybox/sh
            pwd
            /kaniko/executor --context "`pwd`" --destination swashbuck1r/${IMAGE}:${VERSION}
            '''
           }
        }
      }
    }
    stage('Deplopy to K8s') {
      steps {
        container('helm') {
          sh ' echo "helm xxxxxxx" '
        }
      }
    }
  }
}
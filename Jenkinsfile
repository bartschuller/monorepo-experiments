#!/usr/bin/env groovy

pipeline {
    agent any

    stages {
        stage('init') {
            steps {
                script {
                    def sbtHome = tool 'sbt'
                    env.sbt= "${sbtHome}/bin/sbt -no-colors -batch"
                }
            }
        }
        stage('Test') {
            steps {
                sh "cd monorepo-library && $sbt test"
                sh "cd play-a && $sbt test"
                sh "cd play-b && $sbt test"
            }
            post {
                always {
                    junit "*/target/test-reports/*.xml"
                }
            }
        }
//        stage('Deploy') {
//            steps {
//                echo 'Deploying....'
//            }
//        }
    }
}
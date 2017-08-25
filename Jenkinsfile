#!/usr/bin/env groovy

pipeline {
    agent {
        node {
            label 'common-ws-agent'
            customWorkspace 'monorepo-experiments-master'
        }
    }

    stages {
//        stage('init') {
//            steps {
//                script {
//                    def sbtHome = tool 'sbt'
//                    env.sbt= "${sbtHome}/bin/sbt -no-colors -batch"
//                    def scmVars = checkout scm
//                    print scmVars
//                }
//            }
//        }
        stage('monorepo-library') {
            steps {
                build 'monorepo-library'
            }
        }
        stage('play-a') {
            steps {
                build 'play-a'
            }
        }
//        stage('Deploy') {
//            steps {
//                echo 'Deploying....'
//            }
//        }
    }
}
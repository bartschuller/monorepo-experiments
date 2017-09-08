#!/usr/bin/env groovy

pipeline {
    agent {
        node {
            label 'common-ws-agent'
            customWorkspace 'monorepo-experiments-master'
        }
    }

    stages {
        stage('init') {
            steps {
                script {
                    echo sh(returnStdout: true, script: 'env')
                    def scmVars = checkout scm
                    echo scmVars
                    echo sh(returnStdout: true, script: 'env')
                }
            }
        }
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
    }
}

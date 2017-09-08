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
                    def scmVars = checkout scm
                    env.MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT = scmVars.GIT_PREVIOUS_SUCCESSFUL_COMMIT
                }
            }
        }
        stage('monorepo-library') {
            when {
                expression {
                    matches = sh(returnStatus:true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^monorepo-library'")
                    return !matches
                }
            }
            steps {
                build 'monorepo-library'
            }
        }
        stage('play-a') {
            when {
                expression {
                    matches = sh(returnStatus: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^play-a'")
                    return !matches
                }
            }
            steps {
                build 'play-a'
            }
        }
        stage('play-b') {
            when {
                expression {
                    matches = sh(returnStatus: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^play-b'")
                    return !matches
                }
            }
            steps {
                build 'play-b'
            }
        }
    }
}

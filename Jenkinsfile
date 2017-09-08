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
                    print scmVars
                    env.MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT = scmVars.GIT_PREVIOUS_SUCCESSFUL_COMMIT
                    echo sh(returnStdout: true, script: 'env')
                }
            }
        }
        stage('monorepo-library') {
            when {
                expression {
                    matches = sh(returnStdout: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep '^monorepo-library'")
                    return matches != ''
                }
            }
            steps {
                build 'monorepo-library'
            }
        }
        stage('play-a') {
            when {
                expression {
                    matches = sh(returnStdout: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep '^play-a'")
                    return matches != ''
                }
            }
            steps {
                build 'play-a'
            }
        }
        stage('play-b') {
            when {
                expression {
                    matches = sh(returnStdout: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep '^play-b'")
                    return matches != ''
                }
            }
            steps {
                build 'play-b'
            }
        }
    }
}

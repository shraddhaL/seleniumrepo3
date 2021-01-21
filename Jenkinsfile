pipeline {
     agent any
	 tools {
        maven 'maven3.6' 
	jdk 'jdk1.8'
    }
	 environment {
        containerName = "shraddhal/seleniumtest2"
        container_version = "1.0.0.${BUILD_ID}"
        dockerTag = "${containerName}:${container_version}"
		     
    }
    stages { 	
	    stage('Clone repository') {
			   steps {	       
				 git 'https://github.com/shraddhaL/selenium_repo3.git' }
        
			   }
	    
	   stage('Build Jar') {
	    
		steps {////
		   	//sh'docker stop $(docker ps -q) || docker rm $(docker ps -a -q) || docker rmi $(docker images -q -f dangling=true)'
        		bat 'docker system prune --all --volumes --force'
		       bat 'mvn clean package'
        }
        }
		
	    stage('compose') {
            steps {
                script {
			//sh 'docker run -d -p 4444:4444 --memory="1.5g" --memory-swap="2g" -v /dev/shm:/dev/shm selenium/standalone-chrome'
			bat 'docker-compose up -d'
			//bat 'mvn test'
                }
	    }
        }
	    
	  
}  

}

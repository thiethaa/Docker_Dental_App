# get the base node image
FROM node:latest

# set the working dir for container
WORKDIR /dental-ui

# copy the json file first
COPY ./package.json /dental-ui

# install npm dependencies
RUN npm install

# copy other project files
COPY . .

# build the folder
CMD [ "npm", "run", "start" ]
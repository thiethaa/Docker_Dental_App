# get the base node image
FROM node:latest

# set the working dir for container
WORKDIR /dental_ui

# copy the json file first
COPY ./package.json /dental_ui

# install npm dependencies
RUN npm install

# copy other project files
COPY . .

# build the folder
CMD [ "npm", "run", "start" ]
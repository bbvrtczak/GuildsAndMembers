# Stage 1: Compile and Build angular codebase

# Use official node image as the base image
FROM node:18.10.0 as build

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to app
COPY ./ /usr/local/app/

# Install all the dependencies
RUN npm install

# Generate the build of the application
RUN npm run build


# Stage 2: Serve app with nginx server

# Use official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY --from=build /usr/local/app/dist/guilds-and-members-ng /usr/share/nginx/html

ENV API_URL http://localhost:8080/api

# Expose port 80
EXPOSE 80

ADD dist/guilds-and-members-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/

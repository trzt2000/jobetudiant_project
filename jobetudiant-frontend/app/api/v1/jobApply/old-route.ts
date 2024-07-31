import axios from 'axios';
import {getServerSession } from 'next-auth';
import { decrypt } from '@/utils/encryption';

export default async function handler(req:any, res:any) {
  const session :any = await getServerSession()

  if(!session)
    res.status(403).end("Unauthorized");

  else if (req.method === 'POST') {
    try {
      const requestBody = req.body;

      const authToken = decrypt(session.access_token)  

      const headers = {
        headers: {
          Authorization: `Bearer ${authToken}`,
        },
      }

      const remoteServerUrl = 'http://localhost:8084/api/jobApplications/apply';

      const response = await axios.post(remoteServerUrl, requestBody, headers);

      res.status(response.status).json(response.data);

    } catch (error:any) {
      res.status(error.response?.status || 500).json({
        message: 'Error sending request to remote server',
        error: error.message,
      });
    }
  } else {
    res.setHeader('Allow', ['POST']);
    res.status(405).end(`Method ${req.method} Not Allowed`);
  }
}

import axios from 'axios';
import {getServerSession } from 'next-auth';
import { decrypt } from '@/utils/encryption';
import { NextResponse, NextRequest } from 'next/server';
import { getAccessToken } from '@/utils/sessionTokenAccessor';

export async function POST(req:NextRequest) {
  console.log(req)
  const session :any = await getServerSession()
  const authToken = await getAccessToken()


  if(!session)
     return NextResponse.json({message : "Unauthorized"},{status : 403})

  else {
    try {

      const requestBody = await req.json()

      const headers = {
        headers: {
          Authorization: `Bearer ${authToken}`,
        },
      }

      const remoteServerUrl = 'http://localhost:8085/api/jobofferposting';

      const response = await axios.post(remoteServerUrl, requestBody, headers);

      //return
      return NextResponse.json({message : response.data},{ status : response.status})

    } catch (error:any) {
      //return
      return NextResponse.json({
        message: 'Error sending request to remote server',
        error: error.message,
      },{ status: error.response?.status || 500 })
    }
  }
}

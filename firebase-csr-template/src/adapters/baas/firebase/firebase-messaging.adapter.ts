/**
 * Firebase Messaging Adapter
 * 
 * Implements MessagingPort interface using Firebase Cloud Messaging SDK.
 */

import {
  getToken as firebaseGetToken,
  onMessage as firebaseOnMessage,
} from 'firebase/messaging';
import { MessagingPort, MessagePayload } from '@/domain/ports';
import { messaging } from '@/lib/firebase';

export class FirebaseMessagingAdapter implements MessagingPort {
  async requestPermission(): Promise<string | null> {
    if (typeof window === 'undefined' || !messaging) {
      return null;
    }

    const permission = await Notification.requestPermission();
    if (permission !== 'granted') {
      return null;
    }

    return await this.getToken();
  }

  async getToken(): Promise<string | null> {
    if (typeof window === 'undefined' || !messaging) {
      return null;
    }

    try {
      const token = await firebaseGetToken(messaging, {
        vapidKey: process.env.NEXT_PUBLIC_FIREBASE_VAPID_KEY,
      });
      return token;
    } catch (error) {
      console.error('Error getting FCM token:', error);
      return null;
    }
  }

  onMessage(callback: (payload: MessagePayload) => void): () => void {
    if (typeof window === 'undefined' || !messaging) {
      return () => {};
    }

    return firebaseOnMessage(messaging, (payload) => {
      callback(payload as MessagePayload);
    });
  }

  async subscribeToTopic(token: string, topic: string): Promise<void> {
    // This requires a backend call to Firebase Admin SDK
    // Implementation would call a cloud function
    throw new Error('subscribeToTopic requires backend implementation');
  }

  async unsubscribeFromTopic(token: string, topic: string): Promise<void> {
    // This requires a backend call to Firebase Admin SDK
    // Implementation would call a cloud function
    throw new Error('unsubscribeFromTopic requires backend implementation');
  }
}

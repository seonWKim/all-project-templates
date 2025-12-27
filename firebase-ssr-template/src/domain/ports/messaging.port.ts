/**
 * Port Interface: Messaging
 *
 * Defines the contract for push notification and messaging services.
 */

export interface MessagePayload {
  notification?: {
    title: string;
    body: string;
    image?: string;
  };
  data?: Record<string, string>;
}

export interface MessagingPort {
  /**
   * Request permission for notifications
   * @returns FCM token if permission granted
   */
  requestPermission(): Promise<string | null>;

  /**
   * Get current FCM token
   */
  getToken(): Promise<string | null>;

  /**
   * Subscribe to messages
   * @returns Unsubscribe function
   */
  onMessage(callback: (payload: MessagePayload) => void): () => void;

  /**
   * Subscribe to a topic
   */
  subscribeToTopic(token: string, topic: string): Promise<void>;

  /**
   * Unsubscribe from a topic
   */
  unsubscribeFromTopic(token: string, topic: string): Promise<void>;
}

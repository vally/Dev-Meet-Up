//
//  SECEvent.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

struct SECEvent {
    let id: Int?
    var type: SECEventType = .undefined
    let name: String?
    let speakers: [SECSpeaker]?
    let date: Date?
    let venue: String?
    let agenda: [SECAgendaItem]?
    let description: String?
}
